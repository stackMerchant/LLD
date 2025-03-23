import Observable.{JobObservable, NewsObservable, WeatherObservable}

object Main {
  def main(args: Array[String]): Unit = {
    println("=== Start Application ===")

    /* Create observables */
    val newsObservable = new NewsObservable
    val jobObservable = new JobObservable
    val weatherObservable = new WeatherObservable

    /* Create observers */
    val jack = new Observer("Jack")
    val jill = new Observer("Jill")
    val humpty = new Observer("Humpty")
    val dumpty = new Observer("Dumpty")

    /* Add observers ot observables */
    newsObservable.addObserver(List(jack, humpty))
    jobObservable.addObserver(List(jill, dumpty))
    weatherObservable.addObserver(List(jill, humpty))

    /* Notify */
    newsObservable.notifyObservers()
    jobObservable.notifyObservers()
    weatherObservable.notifyObservers()

    println("=== End Application ===")
  }
}