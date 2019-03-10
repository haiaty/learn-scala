ACTOR MODEL AND FUTURE

Plain futures and Akka streams are both very economic when it comes to threads. Actors seem to use a few more threads.



https://www.chrisstucchio.com/blog/2013/actors_vs_futures.html
Actor model introduction:
https://danielwestheide.com/blog/2013/02/27/the-neophytes-guide-to-scala-part-14-the-actor-approach-to-concurrency.html



When you need to simply perform an asynchronous task, you should probably stick to using Futures. If, however, you need to also manage mutable state, it’s better to use another abstraction called Actor. Actors are basically objects that communicate with each other and the outside world by means of sending immutable messages. Actors themselves can have mutable state, and usually they do.

Actors are great for isolating mutable state, because the Actor system can ensure that only one thread affects their state at any given time. 

from (https://www.quora.com/Which-among-Scala-Actors-and-Scala-Futures-should-be-preferred-for-concurrency-and-why

)

other akka resources: http://sdanzig.blogspot.com/2013/06/buddychat-simple-example-of-akka-actors.html