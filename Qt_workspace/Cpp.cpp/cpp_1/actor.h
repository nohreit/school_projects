#ifndef ACTOR_H
#define ACTOR_H

#include <iostream>
#include <chrono>
#include <thread>

using namespace std;
using namespace std::this_thread; //sleep_for, sleep_until
using namespace std::chrono; //nanoseconds, system_clock, seconds
class Actor
{
private:
    string label;
    int hitPoint;
    int manaPoint;
    int staminaPoint;
    int atkPoint;
    int defPoint;
    int atkManaPoint;
    int defManaPoint;
//    ActorClass actorClass;
    string displayActor();
public:
    Actor();

    //getters
    string get_label();
    int get_hitPoint();
    int get_manaPoint();
    int get_staminaPoint();
    int get_atkPoint();
    int get_defPoint();
    int get_atkManaPoint();
    int get_defManaPoint();
    int get_actorClass();

    //setters
    void set_label(string label);
    void set_hitPoint(int hp);
    void set_manaPoint(int mp);
    void set_staminaPoint(int sp);
    void set_atkPoint(int ap);
    void set_defPoint(int dp);
    void set_atkManaPoint(int amp);
    void set_defManaPoint(int dmp);
//    void set_actorClass(ActorClass actorClass);

    //actions

    bool isAlive(int hp);
    void checkHP(int hp);
    void attack(Actor b);
    void heal(Actor b);
    void regenSP(Actor b);
    void regenMP(Actor b);
    bool isVictory(Actor b);

    //output
    void display(string str);
};

#endif // ACTOR_H
