#include <iostream>
#include <iomanip>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <vector>

using namespace std;

void autoSpinner(vector <string> l, int c){
  int times[c],key,turns;
  for(int i = 0; i < c; i++){
    times[i] = 0;
  }
  cout << "\nHow many times would you like to spin the wheel?\n>";
  cin >> turns;
  for(int i = 0; i < turns; i++){
    key = rand() % c;
    times[key]++;
  }
  cout << "\nResults after " << turns << " spins.\n";
  cout << "----------------------------------------------------------\n";
  for(int i = 0; i < c; i++){
    //printf("%s54: %d",l[i],times[i]);
    //cout << l[i] << "\t: " << times[i] << "\n";
    cout << left << setw(48) << setfill(' ') << l[i];
    cout << setw(0) << ": " << times[i] << "\n";
  }
}

void spinner(vector <string> l, int c){
  int times[c];
  for(int i = 0; i < c; i++){
    times[i] = 0;
  }
  int key;
  string d;
  cout << "\nSpinning the wheel first time.\n";
  key = rand() % c;
  times[key]++;
  cout << "\nWheel decided : " << l[key] << "\n";
  while(1){
    cout << "\nSpin again? YES OR NO\n>";
    getline(cin,d);
    if(d == "YES"){
      key = rand() % c;
      cout << "\nWheel decided : " << l[key] << "\n";
      times[key]++;
      cout << "\nChoice stats\n";
      cout << "----------------------------------------------------------\n";
      for(int i = 0; i < c; i++){
        //printf("%s54: %d",l[i],times[i]);
        //cout << l[i] << "\t: " << times[i] << "\n";
        cout << left << setw(48) << setfill(' ') << l[i];
        cout << setw(0) << ": " << times[i] << "\n";
      }
    }else if(d == "NO"){
      cout << "\nExiting wheel.\n";
      break;
    }else{
      cout << "\nInvalid input.\n";
    }
  }
}

int main(int argc, char *argv[]){
  srand(atoi(argv[1]));
  string choice;
  vector <string> choiceList;
  int count = 0;
  while(1){
    cout << "\nEnter a new choice? YES or NO\n>";
    getline(cin,choice);
    if(choice == "YES"){
      count++;
      cout << "\nWhat is your choice?\n>";
      getline(cin,choice);
      choiceList.push_back(choice);
    }else if(choice == "NO"){
      break;
    }else{
      cout << "\nInvalid input.\n";
    }
  }
  bool outer = true;
  if(count == 0){
    cout << "\nNo choices entered. Exiting.\n\n";
  }else{
    while(outer){
      cout << "\nUse wheel spinner? YES or NO\n>";
      getline(cin,choice);
      if(choice == "YES"){
        while(1){
          cout << "\nSpin wheel manually? YES or NO\n>";
          getline(cin,choice);
          if(choice == "YES"){
            spinner(choiceList,count);
            outer = false;
            break;
          }else if(choice == "NO"){
            autoSpinner(choiceList,count);
            outer = false;
            break;
          }else{
            cout << "\nInvalid input.\n";
          }
        }
      }else if(choice == "NO"){
        cout << "\nYour random choice is : " << choiceList[rand() % count] << "\n\n";
        break;
      }else{
        cout << "\nInvalid input.\n";
      }
    }
  }
  cout << "\nExiting program. Have a nice day!\n";
  return 0;
}