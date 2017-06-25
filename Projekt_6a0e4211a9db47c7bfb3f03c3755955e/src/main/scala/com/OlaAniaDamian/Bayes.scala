package com.OlaAniaDamian

import org.apache.spark.sql.{Dataset, SparkSession}
import org.apache.spark.sql.functions.col
import java.io.File
import java.io.FileInputStream
import org.json4s.jackson.Json
import scala.collection.mutable.MutableList
import scala.io.Source
import scala.util.parsing.json.JSON._


class Bayes {

  val sparkSession = SparkSession.builder.
    master("local")
    .appName("spark session example")
    .getOrCreate()


  def bayesData {
    val stream = new FileInputStream("./src/main/resources/dane.json")
    val source: String = Source.fromFile("./src/main/resources/dane.json").getLines.mkString
    val source2 = source.replaceAll("\t", "")
    val source3 = source2.replaceAll("\"", "")
    val source4 = source3.replaceAll(" ", "")
    val source5 = source4.replaceAll("\\[", "")
    val source6 = source5.split(":")(2)
    val source7 = source6.replaceAll("\\]","")
    val source8 = source7.replaceAll("\\{","")
    val source9 = source8.replaceAll("\\}","")
    val data = source9.split(",")
    println("Dane:")
    println(data.mkString(","))
    val x1 = MutableList[Int]()
    val y1 = MutableList[Int]()
    val x2 = MutableList[Int]()
    val y2 = MutableList[Int]()
    for(i <- 0 until data.length-3 by 4){
      x1 += data(i).toInt
      y1 += data(i+1).toInt
      x2 += data(i+2).toInt
      y2 += data(i+3).toInt
    }
    print("\nx1: ")
    print(x1.mkString(", "))
    print("\ny1: ")
    print(y1.mkString(", "))
    print("\nx2: ")
    print(x2.mkString(", "))
    print("\ny2: ")
    print(y2.mkString(", "))
    

  }
}