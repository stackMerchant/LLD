object Main {
  def main(args: Array[String]): Unit = {

    println("=== Start Application ===")

    List(new FamilyVehicle, new SportsVehicle, new OffRoadVehicle).foreach(v => println(v.intro))

    println("=== End Application ===")
  }
}