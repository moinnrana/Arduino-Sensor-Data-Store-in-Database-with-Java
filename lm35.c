const int LM35 = A0;
double temperatura;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
}

void loop() {
  // put your main code here, to run repeatedly:
  temperatura = (double(analogRead(LM35))*5/(1023))/0.01;
  Serial.println(temperatura);
  delay(2000);
}