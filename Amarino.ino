#include <MeetAndroid.h>

MeetAndroid meetAndroid;
int led = 13;

void SwitchOn(byte flag, byte numOfValues)
{
  digitalWrite(led, meetAndroid.getInt()); // 0 ou 1
  digitalWrite(led, HIGH);
}
void SwitchOff(byte flag, byte numOfValues)
{
  digitalWrite(led, meetAndroid.getInt()); // 0 ou 1
  digitalWrite(led, LOW);
}

void setup()
{
  pinMode(led,OUTPUT);

  // Registro das funções, de acordo com o valor recebido: O: Liga o LED; F: Desliga o LED
  meetAndroid.registerFunction(SwitchOn, 'O');
  meetAndroid.registerFunction(SwitchOff, 'F');  
}

void loop()
{

  // Recebe os eventos via Bluetooth:   
  meetAndroid.receive(); 
  
  // digitalWrite(13,HIGH); // High = 1: Acende
  // delay(500);

  // digitalWrite(13,LOW); // Low = 0: Apaga
  // delay(500);    
}


