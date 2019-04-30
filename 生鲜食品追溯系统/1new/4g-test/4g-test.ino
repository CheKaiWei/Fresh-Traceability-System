#include <SoftwareSerial.h>
#include <dht11.h>

//SoftwareSerial portone(8,9) ;
#define DHT11PIN 2
String message;
dht11 DHT11;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(115200); 
  Serial.println("usr.cnAT+WKMOD=NET");   //设置工作模式为网络透传
  delay(10); 
  /*
  Serial.println("usr.cnAT+SOCKAEN=ON");    //使能SocketA
  delay(10); 
  Serial.println("usr.cnAT+SOCKA=TCP,120.78.89.20,8080");   //设置SocketA的网络协议、地址、端口
  delay(10); 
  Serial.println("usr.cnAT+ UARTFL=10");    //设置串口数据打包长度
  delay(10); 
  Serial.println("usr.cnAT+SOCKASL=LONG");    //设置SocketA连接方式
  */
  /*
  while (!Serial) {}
  portone.begin(115200);
  portone.println("AT+UARTFT=100");*/
}

void loop() {
  // put your main code here, to run repeatedly:
    //获取温湿度传感器检测到的值
  int chk = DHT11.read(DHT11PIN);
  float humidityTemp = (float)DHT11.humidity;
  String humidityValue = ((String)humidityTemp).substring(0,5);
  float temperatureTemp = (float)DHT11.temperature;
  String tempeatureValue = ((String)temperatureTemp).substring(0,5);
  message = "usr.cnAT+SMSEND=8613760255245," + humidityValue + tempeatureValue;
  Serial.println(message);
  delay(5000);
}
