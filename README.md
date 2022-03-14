# README

- 性能问题

```
100次 -- 0.4245072s
200次 -- 0.5345263s

执行一次仅需0.0011
但是初始化等等比较耗时

理解没错吧...
```

![](https://luo0412.oss-cn-hangzhou.aliyuncs.com/1647226024589.png)

# 常见问题

- 数组的正确转换 @fix

```
需要声明为数组
直接ArrayList传递会报错

===
int[] ids = new int[]{1,2};

或者
idList.toArray()
```

![](https://luo0412.oss-cn-hangzhou.aliyuncs.com/1647222832934.png)

![](https://luo0412.oss-cn-hangzhou.aliyuncs.com/1647222803142.png)

