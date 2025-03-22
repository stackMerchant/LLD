sealed trait Vehicle {
  def asString: String
  def driveStrategy: DriveStrategy
  def intro: String = "I am " + asString + " and I : " + driveStrategy.asString
}

class OffRoadVehicle extends Vehicle {
  override val asString: String = "OFF_ROAD_VEHICLE"
  override val driveStrategy: DriveStrategy = DriveStrategy.GoSlow
}

class SportsVehicle extends Vehicle {
  override val asString: String = "SPORTS_VEHICLE"
  override val driveStrategy: DriveStrategy = DriveStrategy.GoFast
}

class FamilyVehicle extends Vehicle {
  override val asString: String = "FAMILY_VEHICLE"
  override val driveStrategy: DriveStrategy = DriveStrategy.GoFast
}