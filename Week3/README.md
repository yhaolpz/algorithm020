学习笔记

全排列2 的剪枝条件：
```java
if(i>0 && nums[i] == nums[i-1] && used[i-1]) continue;

或

if(i>0 && nums[i] == nums[i-1] && !used[i-1]) continue;
```

第一种容易理解。

第二种如何理解？ 为什么效率比第一种高？ 
