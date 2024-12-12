
###### Avancerad_JAVA24_Erik_Hultqvist_Uppgift2
# Student Manager System

---
## Table of Contents
1. <ins>[Description of Project](#1-description-of-project)<ins/>
2. <ins>[Running the Application](#2-running-the-application)<ins/>
3. <ins>[Architecture oversight](#3-architecture-oversight)<ins/>
---
### 1. Description of Project
This Project is a **Student Manager Systeml** application that you run in the console where you can add, search, show Students
and save them to file.

---
### 2. Running the Application
To run the application you can use an IDEA like; IntelliJ or VisualStudioCode and navigate through the Menu-System  
with a keyboard.

---
### 3. Architecture oversight
#### - DataStructure
When choosing between data structure I went for LinkedList which has fast insertion and maintains the order of elements.
At first i thougt of having the HashMap hold the students ID as a "key", but then when considering it doesn´t come in numeric
order, I choose LinkedList.