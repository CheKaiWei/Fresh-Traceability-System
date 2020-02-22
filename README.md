# Fresh Traceability System 生鲜追溯系统
__Update：__ 
2018.12.1

__Project:__
The project is to combine the machine vision and sensor technology to monitor the cold chain fresh logistics. As the project leader is responsible for building the system web site, coordinate the entire team to complete the project, the language is Java, the framework is javaEE. The final team won the "Challenge Cup Third Prize".
项目为结合机器视觉和传感器技术，监测冷链生鲜的物流。作为项目组长，负责构建系统web端，协调全整个队伍完成项目，并负责机器视觉识别生鲜肉的新鲜程度。并最终团队获得“挑战杯三等奖”。


__Environment__: Java

# Introduction 简介
社会现实意义：
生鲜食品市场进入快速发展期，同时也诱使一些不法经营者进入市场，导致食品安全事件频发。对此，我们通过一体化的溯源体系，有效监控了产品包装、储存、运输等各个环节，一旦出现异常情况能够及时处理，保障消费者的合法权益。

项目介绍：
本追溯系统利用机器视觉、多传感器融合技术、二维码加密算法以及智能检测盒子对物流过程中的生鲜食品进行全方位的监管和监测。
 
![t1](/t1.png)  
图一、系统应用场景

 ![t1](/t2.png)  
图二、系统原理图
项目创新点：
技术创新点：
机器视觉：
在物流的运输、仓储交接过程，用摄像头采集食品图像，进行图像处理、特征值提取和特征值匹配，得出生鲜食品的新鲜程度。
通过均值滤波去噪，利用灰度化和二值化进行背景分割，然后提取RGB、HSV 和 Lab 三个模型中各单通道图像的灰度平均值和标准偏差，将其作为特征值。
对提取后的18个特征值进行BP 神经网络的模型训练，建立各种食品的知识领域库，与相应的新鲜等级。

 ![t1](/t3.png)
图三、机器视觉图像处理


多传感器融合
构建专家系统，对传感器所获取的温湿度、O2、酒精等数据加以综合，采用加权平均融合算法、多贝叶斯估计法对其进行数据融合、分析计算临界阈值。
利用这些环境变量的变化趋势、浓度，结合不同的生鲜食品种类不同指标，能够检测出生鲜食品是否处于最合理的运输环境中，并且可以从多物理域监测和判断中得出一个理化指标，用于测定生鲜食品的新鲜程度。
对气体传感器融合后得出的生鲜食品的新鲜程度与BP 神经网络判断后的新鲜程度进行主成分分析，得出二次融合后的新鲜程度
此融合系统利用来自不同传感器的信息进行互补，消除了单传感器的工作盲区。

 ![t1](/t4.png)
图四、多传感器融合Web展示

功能创新点：
智能追溯系统设计
方案创新：
目前大多数的生鲜电商仍采用较为普通的防伪和追溯手段，如单一的RFID标签，成本高环境适应性差，且操作麻烦。
结合二维码防伪技术，用户通过扫描商品外包装的防伪码即可获得该项产品物流运输储存过程各环节的环境信息。
盒子在物流整个过程中，跟随并检测商品，数据实时上传，可以在web端直观地监测商品的所有信息，从而实现全面的监管和监测。


# Contact
Feel to contact me. My email is richardfeynman180778@gmail.com
