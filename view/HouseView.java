package com.hll.recent.view;

import com.hll.recent.domain.House;
import com.hll.recent.service.Services;
import com.hll.recent.utils.Utility;

import javax.swing.plaf.nimbus.AbstractRegionPainter;

public class HouseView {
    private boolean loop = true;
    private char key = ' ';
    private Services service = new Services(3);

    //修改房屋信息
    public void updateHouse() {
        System.out.println("\t\t\t\t\t==============修改房屋信息=============");
        System.out.println("请选择修改房屋的编号（-1退出）");
        int upId = Utility.readInt();
        if (upId == -1) {
            System.out.println("您推出了修改房屋系统");
            return;
        }
        House house = service.findByid(upId);
        if (house == null) {
            System.out.println("你所需修改的id不存在");
            return;
        }
        System.out.print("姓名(" + house.getName() + "):");
        String name = Utility.readString(10, "");
        if (!"".equals(name)) {
            house.setName(name);
        }

        System.out.print("电话(" + house.getPhone() + "):");
        String phone = Utility.readString(12, "");
        if (!"".equals(phone)) {
            house.setPhone(phone);
        }

        System.out.print("地址(" + house.getAddress() + "):");
        String address = Utility.readString(50, "");
        if (!"".equals(address)) {
            house.setAddress(address);
        }

        System.out.print("租金(" + house.getRecent() + "):");
        int recent = Utility.readInt(-1);
        if (recent != -1) {
            house.setRecent(recent);
        }

        System.out.print("状态(" + house.getState() + "):");
        String state = Utility.readString(3, "");
        if (!"".equals(state)) {
            house.setState(state);
        }
        System.out.println("==================修改房屋信息成功=======================");


    }


    //查找房屋信息
    public void findHouse() {
        System.out.println("\t\t\t\t\t==============查找房屋信息=============");
        System.out.println("请输入您要查找的id");
        int findId = Utility.readInt();
        House house = service.findByid(findId);
        if (house != null) {
            System.out.println(house);
        } else {
            System.out.println("没有查找到");
        }

    }


    public void exit() {
        char c = Utility.readConfirmSelection();
        if (c == 'Y') {
            loop = false;
        }
    }

    public void Housedel() {
        System.out.println("\t\t\t\t\t==============删除房屋=============");
        System.out.println("请输入待删除房屋的编号（-1退出）");
        int delId = Utility.readInt();
        if (delId == -1) {
            System.out.println("退出删除系统");
            return;
        }

        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {
            if (service.del(delId)) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败，没有该编号");
            }

        } else {
            System.out.println("放弃删除");
        }
    }


    public void addHouse() {//实现在主菜单显示添加功能
        System.out.println("\t\t\t\t\t==============添加房屋=============");
        System.out.println("姓名：");

        String name = Utility.readString(10);
        System.out.println("电话：");
        String phone = Utility.readString(11);
        System.out.println("地址：");
        String address = Utility.readString(50);
        System.out.println("月租：");
        int recent = Utility.readInt();
        System.out.println("状态：（未出租/已出租）");
        String state = Utility.readString(5);

        House newhouse = new House(0, name, phone, address, recent, state);
        if (service.add(newhouse)) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }


    }


    public void listHouses() {//显示所有房屋信息
        System.out.println("\t\t\t\t\t==============房屋列表=============");
        System.out.println("编号\t\t房主\t\t电话\t\t\t地址\t\t月租\t\t状态（已出租/未出租）");
        House[] houses = service.list();
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("\t\t\t\t==========房屋列表显示完毕==============");
    }

    public void mainMenu() {//主菜单

        do {
            System.out.println("==============房屋出租系统菜单=============");
            System.out.println("\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t2 查 找 房 源");
            System.out.println("\t\t\t3 删 除 房 源 信 息");
            System.out.println("\t\t\t4 修 改 房 源 信 息");
            System.out.println("\t\t\t5 房 屋 列 表 信 息");
            System.out.println("\t\t\t6 退\t\t出");
            System.out.println("请输入数字1-6来进行功能选择");
            key = Utility.readChar();
            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    Housedel();
                    break;
                case '4':
                    updateHouse();
                    break;
                case '5':
                    this.listHouses();
                    break;
                case '6':
                    exit();
                    break;
            }

        } while (loop);
    }
}



