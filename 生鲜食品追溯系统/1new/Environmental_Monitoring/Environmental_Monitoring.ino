#include <dht11.h> //温湿度传感器头文件

String message = "";
String Error = "It's work";
int time_lag = 1; //定义数据发送间隔,单位为秒（s）
int j=0;//循环变量

//定义温湿度和氧气传感器所需变量
dht11 DHT11;
int chk,Vo2;
float humidityTemp,temperatureTemp,k,O2ValueTemp;
String humidityValue,tempeatureValue,O2Value;
//定义CO传感器所需变量
int Vco,COValue,COlength;
double kco1,kco2,COValueTemp;
String COStr2;
//定义CO2传感器所需变量
int Vco2,CO2length;
double CO2ValueTemp,CO2Value,kCO21;
String CO2Str2;
//定义酒精传感器所需变量
int Vjj,jjValue;
double kjj1,kjj2,jjValueTemp;
String jjStr2;

//定义GPS模块所需结构体及变量
struct
{
  char GPS_Buffer[80];
  bool isGetData; //是否获取到GPS数据
  bool isParseData; //是否解析完成
  char UTCTime[11]; //UTC时间
  char latitude[11]; //原始纬度
  char N_S[2]; //N/S
  char longitude[12]; //原始经度
  char E_W[2]; //E/W
  bool isUsefull; //定位信息是否有效
} Save_Data;

struct
{
  char BJTime[9]; //北京时间
  char latitude[11]; //纬度
  char longitude[12]; //经度
} Final_Data;

const unsigned int gpsRxBufferLength = 600;
char gpsRxBuffer[gpsRxBufferLength];
unsigned int ii = 0;

//初始化
void setup()
{
  Serial.begin(9600); 
  
//  Serial.println("usr.cnAT+WKMOD=NET"); //设置工作模式为网络透传
//  delay(10); 
//  Serial.println("usr.cnAT+SOCKAEN=ON"); //使能SocketA
//  delay(10); 
//  Serial.println("usr.cnAT+SOCKA=TCP,172.31.105.149,80"); //设置SocketA的网络协议、地址、端口
//  //Serial.println("usr.cnAT+SOCKA=TCP,test.usr.cn,2317");
//  delay(10); 
//  //Serial.println("usr.cnAT+ UARTFL=46"); //设置串口数据打包长度
//  Serial.println("usr.cnAT+UARTFT=1500"); //设置串口数据打包时间
//  delay(10); 
//  Serial.println("usr.cnAT+SOCKASL=LONG"); //设置SocketA连接方式
//  delay(10); 
  
  Save_Data.isGetData = false;
  Save_Data.isParseData = false;
  Save_Data.isUsefull = false;
  
}

//主循环
void loop()
{
  gpsRead(); //获取GPS数据
  parseGpsBuffer(); //解析GPS数据
  printGpsBuffer(); //输出解析后的数据
}

//获取GPS数据
void gpsRead()
{
  while (Serial.available())
  {
    gpsRxBuffer[ii++] = Serial.read();
    if (ii == gpsRxBufferLength)clrGpsRxBuffer();
  }

  char* GPS_BufferHead;
  char* GPS_BufferTail;
  if ((GPS_BufferHead = strstr(gpsRxBuffer, "$GPRMC,")) != NULL || (GPS_BufferHead = strstr(gpsRxBuffer, "$GNRMC,")) != NULL )
  {
    if (((GPS_BufferTail = strstr(GPS_BufferHead, "\r\n")) != NULL) && (GPS_BufferTail > GPS_BufferHead))
    {
      memcpy(Save_Data.GPS_Buffer, GPS_BufferHead, GPS_BufferTail - GPS_BufferHead);
      Save_Data.isGetData = true;

      clrGpsRxBuffer(); //清空gpsRxBuffer
    }
  }
}

//解析GPS数据
void parseGpsBuffer()
{
  char *subString;
  char *subStringNext;

  if (Save_Data.isGetData)
  {
    Save_Data.isGetData = false; //置零
    
    for (int i = 0 ; i <= 6 ; i++) //只对GPRMC前6个参数进行解析
    {
      if (i == 0)
      {
        if ((subString = strstr(Save_Data.GPS_Buffer, ",")) == NULL)
          Error = "GPS ERROR";   //解析错误
      }
      else
      {
        subString++;
        if ((subStringNext = strstr(subString, ",")) != NULL)
        {
          char usefullBuffer[2];
          switch (i)
          {
            case 1: memcpy(Save_Data.UTCTime, subString, subStringNext - subString);break; //获取UTC时间
            case 2: memcpy(usefullBuffer, subString, subStringNext - subString);break; //数据是否可用
            case 3: memcpy(Save_Data.latitude, subString, subStringNext - subString);break; //获取原始纬度信息
            case 4: memcpy(Save_Data.N_S, subString, subStringNext - subString);break; //获取N/S
            case 5: memcpy(Save_Data.longitude, subString, subStringNext - subString);break; //获取原始经度信息
            case 6: memcpy(Save_Data.E_W, subString, subStringNext - subString); break; //获取E/W

            default: break;
          }        
          subString = subStringNext;
          Save_Data.isParseData = true;
          if (usefullBuffer[0] == 'A')
            Save_Data.isUsefull = true;
          else if (usefullBuffer[0] == 'V')
            Save_Data.isUsefull = false;
        }
        
        else
        {
          Error = "GPS ERROR";  //解析错误
        }
        
      }
    } 
  }

  char Hour[11];
  char Min[3];
  char Sec[3];
  char Deg[13];
  char MinSec2[3];
  char MinSec5[6];
  
  //获取北京时间
  memcpy(Hour, Save_Data.UTCTime, 2);
  int h;
  h = atoi(Hour) + 8;
  if(h >= 24) h = h - 24;
  itoa(Hour, h);
  strcat(Hour, ":");  
  memcpy(Min, Save_Data.UTCTime + 2, 2);
  strcat(Hour, Min);
  strcat(Hour, ":");  
  memcpy(Sec, Save_Data.UTCTime + 4, 2);
  strcat(Hour, Sec);
  strcpy(Final_Data.BJTime, Hour);
  memset(Hour, 0, 11);
  memset(Min, 0, 3);
  memset(Sec, 0, 3);

  //获取纬度信息
  memset(Deg, 0, 10);
  memcpy(Deg, Save_Data.latitude, 2);
  strcat(Deg, ".");
  memcpy(MinSec2, Save_Data.latitude + 2, 2);
  strcat(Deg, MinSec2);
  memcpy(MinSec5, Save_Data.latitude + 5, 5);
  strcat(Deg, MinSec5);
  strcpy(Final_Data.latitude, Deg);
  memset(Deg, 0, 11);
  memset(MinSec2, 0, 3);
  memset(MinSec5, 0, 6);

  //获取经度信息
  memcpy(Deg, Save_Data.longitude, 3);
  strcat(Deg, ".");
  memcpy(MinSec2, Save_Data.longitude + 3, 2);
  strcat(Deg, MinSec2);
  memcpy(MinSec5, Save_Data.longitude + 6, 5);
  strcat(Deg, MinSec5);
  strcpy(Final_Data.longitude, Deg);
  memset(Deg, 0, 15);
  memset(MinSec2, 0, 3);
  memset(MinSec5, 0, 6);
}

//输出解析后的数据
void printGpsBuffer()
{
  if (Save_Data.isParseData)
  {
    Save_Data.isParseData = false; //置零

    //Serial.print("BJTime = ");
    //Serial.print(Final_Data.BJTime);
    //Serial.println(Save_Data.UTCTime);

    if (Save_Data.isUsefull)
    {
      Save_Data.isUsefull = false;
      //Serial.print("Latitude = ");
      //Serial.print(Final_Data.latitude);
      //Serial.println(Save_Data.latitude);
      //Serial.print("N_S = ");
      //Serial.print(Save_Data.N_S);
      //Serial.print("Longitude = ");
      //Serial.print(Final_Data.longitude);
      //Serial.println(Save_Data.longitude);
      //Serial.print("E_W = ");
      //Serial.print(Save_Data.E_W);

      //字符数组转字符串
      String N_SStr(Save_Data.N_S);
      String E_WStr(Save_Data.E_W);
      String BJTimeStr(Final_Data.BJTime);
      String latitudeStr(Final_Data.latitude);
      String longitudeStr(Final_Data.longitude);
      
      //获取温湿度传感器检测到的值
      chk = DHT11.read(2);
      humidityTemp = (float)DHT11.humidity;
      humidityValue = ((String)humidityTemp).substring(0,5);
      temperatureTemp = (float)DHT11.temperature;
      tempeatureValue = ((String)temperatureTemp).substring(0,5);

       //O2
      Vo2 = map(analogRead(A4),0,1023,0,5000);
      k = (20.9-9.3)/(1.031-0.45);
      O2ValueTemp = 20.9-k*(Vo2/1000.0-0.45);
      O2Value = ((String)O2ValueTemp).substring(0,5);
      
      //CO
      Vco = map(analogRead(A1),0,1023,0,5000);//�从A1读取RL电压
      kco1 = (log10(0.09)-0)/(log10(4000)-2);  //CO特性曲线斜率
      //double kco2 = ((5.0-Vco/1000.0)/(Vco/1000.0))*10000;  //测试Ro的值，最终要注释掉
      kco2 = (10000.0/12700.0)*((5.0-Vco/1000.0)/(Vco/1000.0)); //Rs/Ro的值，Ro需经测量得到
      COValueTemp = (log10(kco2)+2*kco1)/kco1;
      //float COValue = pow(10,COValueTemp);   //计算CO的ppm值
      COValue = (int)pow(10,COValueTemp);  
      //String COStr2 = ((String)COValue).substring(0,6);//将CO的值始终保持在六位
      COStr2 = (String)COValue;
      COlength = COStr2.length();
      switch(COlength)
      {
      case(1): COStr2="     "+COStr2;break;
      case(2): COStr2="    "+COStr2;break;
      case(3): COStr2="   "+COStr2;break;
      case(4): COStr2="  "+COStr2;break;
      case(5): COStr2=" "+COStr2;break;
      default: break;
      }

      //CO2
      Vco2 = map(analogRead(A2),0,1023,0,5000);//�从A2读取CO2传感器返回的数值
      kCO21 = (280-310)/(log10(4000)-log10(800));//CO2特性曲线斜率
      CO2ValueTemp = (Vco2-265)/kCO21+4;  //Vco2>325时的特性曲线方程
      if(Vco2<325)
      CO2Value = random(250,400);
      else
      CO2Value = pow(10,CO2ValueTemp);  //转化为CO2的ppm值
      //CO2Str2 = ((String)CO2Value).substring(0,6);
      CO2Str2 = (String)CO2Value;
      CO2length = COStr2.length();
      switch(CO2length)
      {
        case(1): CO2Str2="     "+CO2Str2;break;
        case(2): CO2Str2="    "+CO2Str2;break;
        case(3): CO2Str2="   "+CO2Str2;break;
        case(4): CO2Str2="  "+CO2Str2;break;
        case(5): CO2Str2=" "+CO2Str2;break;
        default: break;
      }

      //酒精
      Vjj = map(analogRead(A3),0,1023,0,5000);//�从A3读取RL电压
      kjj1 = (log10(0.09)-log10(0.03))/(log10(60)-log10(200));  //CO特性曲线斜率
      //kjj2 = ((5.0-Vjj/1000.0)/(Vjj/1000.0))*10000;  //测试Ro的值，最终要注释掉
      kjj2 = (10000.0/670000.0)*((5.0-Vjj/1000.0)/(Vjj/1000.0)); //Rs/Ro的值，Ro需经测量得到
      jjValueTemp = ((log10(kjj2)-log10(0.09))/kjj1)+log10(60);
      //float jjValue = pow(10,jjValueTemp);   //计算CO的ppm值
      jjValue = (int)pow(10,jjValueTemp);  
      jjStr2 = (String)jjValue;

      message = humidityValue +tempeatureValue +  O2Value + COStr2 + CO2Str2 + jjStr2 + BJTimeStr + latitudeStr +  N_SStr + longitudeStr + E_WStr;
      //清空字符串
//      message = "";
//      N_SStr = "";
//      E_WStr = "";
//      BJTimeStr = "";
//      latitudeStr = "";
//      longitudeStr = "";
//      O2Value = "";
//      COStr2 = "";
//      jjStr2 = "";
//      humidityValue = "";
//      tempeatureValue = "";
    }
    else
    {
      Error = "GPS DATA is not usefull!"; //报错
    }

    //通过串口输出字符串
    j++;
    if(Error == "It's work")
    {
        if(j=time_lag)
        {
          j=0;
          Serial.println(message);


        }
    }
    else
    {Serial.println(Error);}
  }
}

//清空gpsRxBuffer
void clrGpsRxBuffer(void)
{
  memset(gpsRxBuffer, 0, gpsRxBufferLength); //清空（将gpsRxBuffer的前gpsRxBufferLength个字节置为0）
  ii = 0;
}

//整型转字符串
char* itoa(char *str, int i)
{
  sprintf(str, "%d", i);
  return str;
}

// 露点（点在此温度时，空气饱和并产生露珠）
double dewPoint(double celsius, double humidity)
{
        double A0= 373.15/(273.15 + celsius);
        double SUM = -7.90298 * (A0-1);
        SUM += 5.02808 * log10(A0);
        SUM += -1.3816e-7 * (pow(10, (11.344*(1-1/A0)))-1) ;
        SUM += 8.1328e-3 * (pow(10,(-3.49149*(A0-1)))-1) ;
        SUM += log10(1013.246);
        double VP = pow(10, SUM-3) * humidity;
        double T = log(VP/0.61078);   // temp var
        return (241.88 * T) / (17.558-T);
}
 
// 快速计算露点，速度是5倍dewPoint()
double dewPointFast(double celsius, double humidity)
{
        double a = 17.271;
        double b = 237.7;
        double temp = (a * celsius) / (b + celsius) + log(humidity/100);
        double Td = (b * temp) / (a - temp);
        return Td;
}

