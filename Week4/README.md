学习笔记

二分细节：

int mid = left + (right - left) / 2;
//mid 向下取整，适用收缩区间为 (mid,right] 

//如果收缩区间为 [mid,right] , 则需要：
int mid = left + (right - left + 1) / 2;
//向上取整，否则 left=mid, 收缩区间时 left = mid 会死循环

注意 while(left <= right)、while(left < right)、while(left +1 < right) 的运用