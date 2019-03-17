package com.imooc.tutorial

object test {
 abstract class Notification

case class Email(sender: String, title: String, body: String) extends Notification

case class SMS(caller: String, message: String) extends Notification

case class VoiceRecording(contactName: String, link: String) extends Notification;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(704); 
 
def showNotification(notification: Notification): String = {
  notification match {
    case Email(email, title, _) =>
      s"You got an email from $email with title: $title"
    case SMS(number, message) =>
      s"You got an SMS from $number! Message: $message"
    case VoiceRecording(name, link) =>
      s"you received a Voice Recording from $name! Click the link to hear it: $link"
  }
};System.out.println("""showNotification: (notification: com.imooc.tutorial.test.Notification)String""");$skip(473); 
def showImportantNotification(notification: Notification, importantPeopleInfo: Seq[String]): String = {
  notification match {
    case Email(email, _, _) if importantPeopleInfo.contains(email) =>
      "You got an email from special someone!"
    case SMS(number, _) if importantPeopleInfo.contains(number) =>
      "You got an SMS from special someone!"
    case _ =>
      showNotification(_) // nothing special, delegate to our original showNotification function
  }
};System.out.println("""showImportantNotification: (notification: com.imooc.tutorial.test.Notification, importantPeopleInfo: Seq[String])String""");$skip(62); 

val importantPeopleInfo = Seq("867-5309", "jenny@gmail.com");System.out.println("""importantPeopleInfo  : Seq[String] = """ + $show(importantPeopleInfo ));$skip(49); 

val someSms = SMS("867-5309", "Are you there?");System.out.println("""someSms  : com.imooc.tutorial.test.SMS = """ + $show(someSms ));$skip(76); 
val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123");System.out.println("""someVoiceRecording  : com.imooc.tutorial.test.VoiceRecording = """ + $show(someVoiceRecording ));$skip(86); 
val importantEmail = Email("jenny@gmail.com", "Drinks tonight?", "I'm free after 5!");System.out.println("""importantEmail  : com.imooc.tutorial.test.Email = """ + $show(importantEmail ));$skip(63); 
val importantSms = SMS("867-5309", "I'm here! Where are you?");System.out.println("""importantSms  : com.imooc.tutorial.test.SMS = """ + $show(importantSms ));$skip(66); 

println(showImportantNotification(someSms, importantPeopleInfo));$skip(76); 
println(showImportantNotification(someVoiceRecording, importantPeopleInfo));$skip(72); 
println(showImportantNotification(importantEmail, importantPeopleInfo));$skip(70); 
println(showImportantNotification(importantSms, importantPeopleInfo))}
}
