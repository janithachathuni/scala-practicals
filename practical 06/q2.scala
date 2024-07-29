import scala.io.StdIn.readLine

object StudentMarks{
  def main(args: Array[String]): Unit ={
    val studentInfo = getStudentInfoWithRetry()
    printStudentRecord(studentInfo)
  }

  def getStudentInfo():(String, Int, Int, Double, Char)={
    val name = readLine("Enter student name: ")
    val marks = readLine("Enter student marks: ").toInt
    val totalMarks = readLine("Enter total possible marks: ").toInt

    val percentage = (marks.toDouble/totalMarks)*100
    val grade = calculateGrade(percentage)

    (name, marks, totalMarks, percentage, grade)
  }

  def printStudentRecord(record: (String, Int, Int, Double, Char)):Unit={
    val (name, marks, totalMarks, percentage, grade) = record

    println(s"Student name: $name")
    println(s"Marks obtained: $marks")
    println(s"Total possible marks: $totalMarks")
    println(f"Percentage: $percentage%.2f%%")
    println(s"Grade: $grade")
  }

  def validateInput(name: String, marks: String, totalMarks: String): (Boolean, Option[String]) = {
    def isPositiveInteger(str: String): Boolean = str.forall(_.isDigit) && str.nonEmpty && str.toInt > 0

    if(name.isEmpty){
      (false, Some("Name cannot be empty."))
    }else if (!isPositiveInteger(marks) || !isPositiveInteger(totalMarks)){
      (false, Some("Marks and total marks must be positive integers."))
    }else{
      val marksInt = marks.toInt
      val totalMarksInt = totalMarks.toInt
      if (marksInt > totalMarksInt) {
        (false, Some("Marks cannot exceed total possible marks."))
      }else{
        (true, None)
      }
    }
  }

  def getStudentInfoWithRetry(): (String, Int, Int, Double, Char)={
    var valid = false
    var name = ""
    var marks = ""
    var totalMarks = ""

    while(!valid){
      name = readLine("Enter student's name: ")
      marks = readLine("Enter student's marks: ")
      totalMarks = readLine("Enter total possible marks: ")

      val(isValid, errorMessage) = validateInput(name, marks, totalMarks)

      if(isValid){
        valid = true
      }else{
        println(s"Error: ${errorMessage.getOrElse("Invalid input")}. Please try again.")
      }
    }

    val marksInt = marks.toInt
    val totalMarksInt = totalMarks.toInt
    val percentage = (marksInt.toDouble / totalMarksInt) * 100
    val grade = calculateGrade(percentage)

    (name, marksInt, totalMarksInt, percentage, grade)
  }

  def calculateGrade(percentage: Double): Char={
    percentage match {
      case p if p >= 90 => 'A'
      case p if p >= 75 => 'B'
      case p if p >= 50 => 'C'
      case _ => 'D'
    }
  }
}
