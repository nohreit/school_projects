#ifndef CREATURE_H
#define CREATURE_H
#include <iostream>
#include "room.h"

using namespace std;

class Creature
{
private:
    string name;
    string description;
    int hitPoints;
    int damage;
    Room room;

public:
    Creature();
    Creature(string, string,
             int, int);
    void attack(Creature);
    void takeDamage(int);
    bool isAlive();
    string toString();

    void setHitPoints(int);
    void setDamage(int);
    void setRoom(Room);

    string getName();
    string getDescription();
    int getHitPoint();
    int getDamage();
    Room getRoom();

};

#endif // CREATURE_H
