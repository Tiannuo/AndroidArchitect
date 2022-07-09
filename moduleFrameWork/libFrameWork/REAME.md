# 学习笔记

## Handler

* 线程间通信

## Binder

* MMAP: Android 本就是基于Linux开发，Linux通过将一个虚拟内存区域与磁盘上的对象关联起来，以初始化此虚拟内存区域的内容，此过程称为内存映射*（memory mapping)。

## IPC 进程间通信对比

* Binder:
  需要进行一次拷贝，进程之间共享内核空间，并且进程的用户空间可以直接访问内核空间，会为每个进程（APP）分配UID，支持实名（系统的进程，电话，视频，蓝牙）或者匿名（开发者新建的Service等）
* 共享内存: 无需拷贝，进程之间可以直接访问，但是安全性较低，容易暴露数据信息
* Socket: 两次拷贝，需要由进程A拷贝数据到内核空间，然后由内核空间拷贝数据到进程B，消耗大

## 启动流程

* java main() -> jvm
* 通过Lancher(app) :zygote(孵化) ->jvm ->ActivityThread.main()