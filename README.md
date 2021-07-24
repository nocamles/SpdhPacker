# jitpackdemo

#### 介绍
组包解包SPDH的一个工具类。主要是测试上传jitpackIO后远程调用。已成功上传打包

#### 使用说明
step1:
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
}
step2:
implementation 'com.gitee.gautohank:SpdhDemo:Hank_Spdh_DemoV1.1'

