package com.hll.recent.service;

import com.hll.recent.domain.House;

public class Services {
    private House[] houses;//定义 houses名的数组，记录房屋信息
    private int houseNum = 1;//记录当前有多少个房屋信息
    private int idCounter = 1;//id自增长记录；从1开始，因为初始有一条信息


    //查找房源的方法,根据id
    public House findByid(int findId){
        for (int i = 0; i <houseNum ; i++) {
            if (findId == houses[i].getId()){
                return houses[i];
            }

        }
        return null;

    }



    //定义一个删除方法
    public boolean del(int delId) {
        int index = -1;
        for (int i = 0; i < houseNum; i++) {
            if (delId == houses[i].getId()) {
                index = i;
            }
        }
        if (index == -1) {
            return false;
        }
        for (int i = index; i < houseNum - 1; i++) {
            houses[i] = houses[i + 1];
        }
        houses[--houseNum] = null;
        return true;


    }


    public Services(int Size) {
        houses = new House[Size];
        houses[0] = new House(1, "小明", "15182312", "海淀区", 2000, "未出租");
    }

    public boolean add(House newhouse) {
        //考虑数组是否能继续添加（先不考虑数组扩容的问题）
        if (houseNum == houses.length) {
            System.out.println("房屋信息已满，不能继续添加了");
            return false;
        }
        //*****注意  这里将newhouse赋值给houses！！！！(一开始没理解为什么能添加到houses数组里面)
        houses[houseNum++] = newhouse;//初始添加的房屋信息下标为0，定义的houseNum从1开始。刚好可以表示接下来房屋信息的下标（0、1、2....）
        //此处要解决id自增长的问题,因在HouseView中定义的id为0。
        ++idCounter;
        newhouse.setId(idCounter);
        return true;

    }//添加房屋的底层代码

    public House[] list() {
        return houses;
    }
}


