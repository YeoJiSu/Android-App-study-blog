package com.example.lab2_1

enum class Year{ Freshman, Sophomore, Junior, Senior }
class Student(var year: Year, var name: String, var id: Int){
    fun print_information() {
        println("Year : ${year}, Name: $name, ID: $id")
    }
}
fun main(){
    var students: MutableList<Student> = mutableListOf()

    students.add(Student(Year.Freshman, "Kin", 202011679))
    students.add(Student(Year.Freshman, "Wang", 202055028))
    students.add(Student(Year.Sophomore, "Kin", 201803049))
    students.add(Student(Year.Junior, "Lee", 201646290))
    students.add(Student(Year.Senior, "Hwangbo", 201412654))


    var freshman_students = students.filter { it.year == Year.Freshman }

    for (student in freshman_students) {
        student.print_information()
    }
}