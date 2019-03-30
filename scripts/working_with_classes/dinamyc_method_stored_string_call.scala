class ClassWithDinamycMethodInvocation {

  def test = {

    var method = "miArr"

    val mtd = this.getClass.getMethod(method)

    val result = mtd.invoke(this)

    println(result)

     method = "anotherMethod"

    val mtd2 = this.getClass.getMethod(method)

    val result2 = mtd2.invoke(this)


  }

  def miArr = {
    "jjj"
  }

  def anotherMethod = "kkp"

}


new ClassWithDinamycMethodInvocation test
