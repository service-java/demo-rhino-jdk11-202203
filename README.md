# README

- 性能问题

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

