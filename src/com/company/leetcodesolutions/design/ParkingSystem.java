package com.company.leetcodesolutions.design;

class ParkingSystem {
    int big;
    int medium;
    int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        if (carType == 1) {
            if (big == 0) return false;
            big--;
        } else if (carType == 2) {
            if (medium == 0) return false;
            medium--;
        } else {
            if (small == 0) return false;
            small--;
        }
        return true;
    }
}
