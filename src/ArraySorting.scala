package com.imooc.tutorial

import scala.collection.mutable.ArrayBuffer
import util.control.Breaks._

object ArraySorting {
    def main(args: Array[String]): Unit = {
        val arr = Array(5, 3, 1, 4, 2)
        println("sortedSort: " + sortedSort(arr).mkString(","))
        println("sortBySort: " + sortBySort(arr).mkString(","))
        println("sortWithSort: " + sortWithSort(arr).mkString(","))
        println("insertSort: " + insertSort(arr).mkString(","))
        println("bubbleSort: " + bubbleSort(arr).mkString(","))
        println("selectionSort: " + selectionSort(arr).mkString(","))
        println("shellSort: " + shellSort(arr).mkString(","))
        println("heapSort: " + heapSort(arr).mkString(","))
        println("mergeSort: " + mergeSort(arr).mkString(","))
        println("quickSort: " + quickSort(arr).mkString(","))
    }

    def sortedSort(a: Array[Int]): Array[Int] = {
        a.sorted
    }

    def sortBySort(a: Array[Int]): Array[Int] = {
        a.sortBy(x => x)
    }

    def sortWithSort(a: Array[Int]): Array[Int] = {
        a.sortWith(_ < _)
    }

    def insertSort(a: Array[Int]): Array[Int] = {
        for (j <- 1 to a.length - 1) {
            val hold = a(j)
            var i = j - 1
            while (i >= 0 && a(i) > hold) {
                a(i + 1) = a(i)
                i = i - 1
            }
            a(i + 1) = hold
        }
        a
    }

    def bubbleSort(a: Array[Int]): Array[Int] = {
        for (j <- 0 to a.length - 3)
            for (i <- 0 to a.length - 2 - j) {
                if (a(i) > a(i + 1)) {
                    val temp = a(i + 1)
                    a(i + 1) = a(i)
                    a(i) = temp
                }
            }
        a
    }

    def selectionSort(a: Array[Int]): Array[Int] = {
        for (i <- 0 until a.length - 1) {
            var index = i
            var value = a(i)
            for (j <- i + 1 until a.length) {
                if (value > a(j)) {
                    index = j
                    value = a(j)
                }
            }
            if (index != i) {
                a(index) = a(i)
                a(i) = value
            }
        }
        a
    }

    def shellSort(a: Array[Int]): Array[Int] = {
        var step = a.size / 2

        while (step > 0) {
            for (i <- 0 until step) {
                for (j <- i + step to (a.size - 1, step)) {
                    if (a(j) < a(j - step)) {
                        var k = j - step
                        while (k > 0 && a(k + step) < a(k)) {
                            swap(a, k, k + step)
                            k -= step
                        }
                    }
                }
            }
            step /= 2
        }
        a
    }

    def heapSort(a: Array[Int]): Array[Int] = {
        val arrayLength = a.length
        for (i <- 0 until arrayLength - 1) {
            buildMaxHeap(a, arrayLength - 1 - i)
            swap(a, 0, arrayLength - 1 - i)
        }
        a
    }

    def buildMaxHeap(a: Array[Int], lastIndex: Int) {
        for (i <- (0 to (lastIndex - 1) / 2).reverse) {
            var k = i
            breakable {
                while (k * 2 + 1 <= lastIndex) {
                    var biggerIndex = 2 * k + 1
                    if (biggerIndex < lastIndex) {
                        if (a(biggerIndex) < a(biggerIndex + 1)) {
                            biggerIndex += 1
                        }
                    }
                    if (a(k) < a(biggerIndex)) {
                        swap(a, k, biggerIndex)
                        k = biggerIndex
                    } else {
                        break
                    }
                }
            }
        }
    }

    def mergeSort(a: Array[Int]): Array[Int] = {
        if (a.length <= 1) {
            a
        } else {
            val (left, right) = a.splitAt(a.length / 2)

            val leftSorted = mergeSort(left)
            val rightSorted = mergeSort(right)

            merge(leftSorted, rightSorted)
        }
    }

    def merge(leftArr: Array[Int], rightArr: Array[Int]): Array[Int] = {
        var left = leftArr
        var right = rightArr

        var leftHead, rightHead = 0

        var result = new ArrayBuffer[Int]()

        while (!left.isEmpty && !right.isEmpty) {
            leftHead = left.head
            rightHead = right.head

            if (leftHead <= rightHead) {
                result += leftHead
                left = left.tail
            } else {
                result += rightHead
                right = right.tail
            }
        }

        if (!left.isEmpty)
            result ++= left
        else if (!right.isEmpty)
            result ++= right

        result.toArray
    }

    def quickSort(a: Array[Int]): Array[Int] = {
        def qSort(a: Array[Int], left: Int, right: Int): Unit = {
            if (left < right) {
                var i = left
                var j = right
                val x = a(i)
                while (i < j) {
                    while (i < j && a(j) > x) j = j - 1
                    if (i < j) {
                        a(i) = a(j)
                        i = i + 1
                    }
                    while (i < j && a(i) < x) i = i + 1
                    if (i < j) {
                        a(j) = a(i)
                        j = j - 1
                    }
                }
                a(i) = x
                qSort(a, left, i - 1)
                qSort(a, i + 1, right)
            }
        }
        qSort(a, 0, a.length - 1)
        a
    }

    def swap(a: Array[Int], i: Int, j: Int) = {
        val temp: Int = a(i)
        a(i) = a(j)
        a(j) = temp
    }
}
