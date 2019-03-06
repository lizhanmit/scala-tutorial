package com.officialSite.tutorial.traits

/**
 * Equivalent of Comparable in Java.
 * From Java 8, interface can also has function body.
 */
trait Ord {
  def < (that: Any): Boolean
  def <= (that: Any): Boolean = (this < that) || (this == that)
  def > (that: Any): Boolean = !(this <= that)
  def >= (that: Any): Boolean = !(this < that)
}