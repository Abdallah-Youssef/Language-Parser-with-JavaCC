# Programming-Paradigms-Lab-1
parser that parse the language below and evaluate the grammer expressions:

Digit  → 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
Letter → a | b | c | d | e | f
Num    → Digit Num  |  ε
Var    →  Letter Var  |  ε
AExp   →  Num | Var | (AExp + AExp) | (AExp −AExp)
BExp   →  tt | ff | (AExp == AExp) | ! BExp | (BExp ^ BExp)
Com    →  skip | Var := AExp | Com; Com | if BExp then Com else Com | while BExp do Com

in addition to Junit tests exits in test package

team: Abdallah Youssef      (عبدالله ياسر ابراهيم عبدالحميد يوسف)     ID: 18015026
      Abdelrahman Elmeniawy (عبدالرحمن أشرف حسن المنياوي)           ID: 18012538
