package org.example
import scala.collection.immutable.List
import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readLine

object App {
  def main(args : Array[String]) {

    println("Задача a.-------------------------------------------------------------")
    var startVarString = "Hello, Scala!"
    println(startVarString)
    println(startVarString.reverse)
    println(startVarString.toLowerCase())
    println(startVarString.replace("!", ""))
    println(startVarString + " and goodbye python!")

    println()
    println("Задача b.-------------------------------------------------------------")
    println("Введите годовой доход: ")
    val yearsSalary = readLine().toInt
    println("Размер премии в процентах: ")
    val bonus = readLine().toFloat
    println("Компенсация питания: ")
    val eatBonus = readLine().toInt
    val monthSalary = ((yearsSalary + yearsSalary * (bonus / 100) + eatBonus) / 12) * 0.87
    print("Ежемесячный доход сотрудника: ")
    println(f"${monthSalary}%6.2f")

    println()
    println("Задача c.-------------------------------------------------------------")
    val salaryList = List(100, 150, 200, 80, 120, 75)
    val commonSalary = salaryList.sum
    val countPerson = salaryList.size
    val meanSalary: Float = commonSalary / countPerson
    print("Средний оклад персонала: ")
    println(f"${meanSalary}%6.2f")
    val otkList = new ListBuffer[Int]()
    println("Список", otkList)
    println("Отклонение оклада работника от среднего оклада")
    for (n <- salaryList) {
        val deviation = ((n - meanSalary)/n * 100).toInt
        println(deviation + "%")
        otkList += deviation
    }
    println("Список отклонений от оклада, в процентах", otkList)

    println()
    println("Задача D.-------------------------------------------------------------")
    val newSalaryList = new ListBuffer[Int]()
    var k: Int = 0
    for (n <- otkList) {
      if (n < 0)
        newSalaryList += (salaryList(k) - 11)
      else
        newSalaryList += (salaryList(k) + 15)

      k = k + 1
    }
    println("Новый список зарплат c добавлением или убавлением ЗП", newSalaryList)
    println("Самая высокая зарплата", newSalaryList.max)
    println("Самая низкая зарплата", newSalaryList.min)


    println()
    println("Задача E.-------------------------------------------------------------")
    val addSalaryList: List[Int] = List(350, 90)
    val newAddSalaryList: List[Int] = salaryList ::: addSalaryList
    println("Список окладов с окладами двух новых сотрудников", newAddSalaryList)
    val sortedSalaryList: List[Int] = newAddSalaryList.sorted
    println("Отсортированный список", sortedSalaryList)

    println()
    println("Задача F.-------------------------------------------------------------")
    println("Введите оклад нового сотрудника:")
    val x = readLine().toInt
    val dim: Int = sortedSalaryList.size
    k = 0
    for (n <- sortedSalaryList) {
      if (x > n)
        k = k + 1
    }
    val (left, right) = sortedSalaryList.splitAt(k)
    val lastSalaryList: List[Int] = left ::: List(x) :::right
    print("Отсортированный список с новым сотрудником", lastSalaryList)

    println()
    println("Задача G.-------------------------------------------------------------")
    println("Номера специалистов уровня middle")
    k = 0
    for (n <- lastSalaryList) {
      if ((n > 90) && (n < 200))
        println(k)
      k = k + 1
    }

    println()
    println("Задача H.-------------------------------------------------------------")
    println("Индексированная зарплата сотрудников")
    for (n <- lastSalaryList) {
      println(n + n * 0.07)

    }

  }

}
