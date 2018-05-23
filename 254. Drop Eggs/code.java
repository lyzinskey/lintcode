//There is a building of n floors. If an egg drops from the k th floor or above, it will break. If it's dropped from any floor below, it will not break.

//You're given two eggs, Find k while minimize the number of drops for the worst case. Return the number of drops in the worst case.

//Example
//Given n = 10, return 4.
//Given n = 100, return 14.


    //若当前楼层为100，x次为最坏情况。
    //当从所有楼层中选定第k层往下丢鸡蛋时，如果这个鸡蛋碎了，那么只剩下另外一个鸡蛋，只能从第一层开始逐步往上丢；
    //当前最坏情况是从第k层开始丢鸡蛋才会碎，那么总共要尝试k - 1次才能知道这个答案。
    //加上在k层丢的那一次，总共要k次才能得到答案，这个k即为所求的x。
    //因此基于能求出答案的最坏情况，第一次最高可以在第x层尝试丢。
    //易知第二次最高可以在第x + x - 1层丢，
    //因为若之前在第x层丢的没有碎则应继续往高层找，
    //而此时已经消耗了一次丢鸡蛋的机会，所以只能往上再增加x - 1层。
    //依次可知, x + (x - 1) + (x - 2) + ... + 2 + 1 >= 100, 求出x最小值是14。
    
    public int dropEggs(int n) {
        // 定义long sum而不是int sum, 防溢出
        long ans = 0;
        for (int i = 1; ; i++) {
            ans += (long) i;
            if (ans >= (long) n)
                return i;
        }
    }
