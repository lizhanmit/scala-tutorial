package com.officialSite.tutorial.classes

class Complex2(real: Double, imaginary: Double) {
  // omit () after name of methods
  // when you invoke them in main function, you can also omit ()
  def re = real 
  def im = imaginary
  
  // add override if you override methods inherited from a super-class
  override def toString() = "" + re + (if (im < 0) "-" else "+") + im + "i" 
}