fun main() {
//Inheritance enables us to create a new class
//from an existing one hence borrowing its functionality
//The child class inherits all the features from the parent class
// but could also have its own attributes
var car = Car("nissan","note","red",7)
    car.carry(9)
    car.carry(3)
    car.identity()
    println(car.calculateParkingFees(50))

    var bus = Bus("type c","martz","red",7)
    bus.calculateParkingFees(2)
    bus.identity()
    bus.carry(14)
    println(bus.maximumAmount(20.0))
    println(bus.calculateParkingFees(24))

    var minMaxAv = MinMaxAv(12,34,8.0)
    println(minMaxAv.average)

}

//Create a class Car with the following attributes: make, model, color, capacity.
//It has these functions:
//- carry(people: Int) : Prints out “Carrying $people passengers” if the
//number of people is within its capacity else it prints out “Over capacity
//by $x people” where x is the number of people exceeding its capacity
//(3 points)
//- identity() : Prints out the color, make and model in the following
//format e.g: “I am a white subaru legacy” (1 point)
//- calculateParkingFees(hours: Int) : Calculates and returns the
//parking fees by multiplying the hours by 20

open class Vehicle(var make: String,var model: String,var color: String,var capacity: Int){
    fun carry(people: Int){

        var x=people-capacity
        if (people <= (capacity)){
            println("Carrying $people passengers")}
        else{
            println("Over capacity by $x people")}
    }
    fun identity(){
        println("I am a $color $make $model")
    }
    open fun calculateParkingFees(hours: Int): Int{
        var calculation= hours*20
        return calculation
    }
}

class Car( make: String,model: String,color: String,capacity:Int):Vehicle(make, model, color, capacity){
}

//Create a class Bus with the same attributes and functions as the Car class.
//In addition, it has another method called maxTripFare(fare: Double) that
//calculates and returns the maximum amount of fare that can be collected per
//trip. (2 points)
//The bus’ calculateParkingFees method returns the product of hours and
//the capacity of the bus

class Bus(make: String,model: String,color: String,capacity: Int):Vehicle(make, model, color, capacity){
    fun maximumAmount(fare: Double): Double{
        return fare.times(capacity)
    }

    override fun calculateParkingFees(hours: Int): Int {
//        return super.calculateParkingFees(hours)
        var calc=hours*capacity
        return calc

    }
}
//Write and invoke one function that takes in an array of integers and returns
//these 3 values: smallest, largest and average of all the elements
data class MinMaxAv(val min: Int,val max: Int,val average: Double)
fun arrayNumbers(numbers: Array<Int>) :MinMaxAv {
    val min = numbers.min()
    val max = numbers.max()
    val average = numbers.average()
    return MinMaxAv(min, max, average)
}