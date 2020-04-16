# 快速入门
基于Spring AOP的Controller增强器实现的统一响应示例

其中对高并发的一些基本数据类型进行了使用，本程序结构可用于高并发的web项目。


## 背景
本项目是为了解决`HTTP`接口返回统一格式的`JSON body`问题。

## 运行环境
1. `JDK 1.8`或以上版本
2. `maven 3.1.0`或以上版本
3. 安装`lombok`插件 
4. `springboot2.x`版本

## 快速启动
1. 运行`SpringWebParamValidateDemoApplication`的`main`方法即可启动项目
2. 然后在浏览器/postman工具中进行以下操作就可以看到统一响应体的示例运行效果了
    1. 访问`http://locahost:8080/users/0`，返回结果如下：
        ```
        {
          "code": 404,
          "msg": "资源不存在",
          "data": null
        }
        ```


对应博文讲解地址：
https://blog.csdn.net/ITBigGod/article/details/105567916

更多接口规范：
https://blog.csdn.net/ITBigGod/article/details/105560158



2020/4/16

