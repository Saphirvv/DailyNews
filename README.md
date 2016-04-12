# DailyNews
An exercise for MVP pattern~ also using the RSS parse with SAX~  Partly FINISHED=、=

## Problems
___
#### Problem NOW:
If I would like to make that `DetailPage` to detect the switch gesture for changing what is shown of that `WebView`. I should transport the para like the `List<News>` to there.  
But the problem is, that `Intent` looks like can't put that much things...(I don't know what else to explain...)  
After all, *I will figure it out*
___
#### Problem 1:(solved)
WHY DOES THIS CODE NOT WORK ?!
```Java
nputStream mInputStream = urlc.getInputStream();
```
With no exception...only can be seen through the logcat...
*Because we COULD NOT using a delay operator in the main thread, which exactly the NET CONNECTION is.*

#### Problem 2:(solved)
About Bundle transform between the two Activity...  
Actually I know how to receive the parameter in the normal way...but not in this mvp pattern...= =So sad. 
*WHERE* Should I get that bundle ? 
*SOLVE:*We could put the methods about set or get Bundle in the View part.And then using them through the function of the presenter by invoke...At least I think it should be like this...

#### Problem 3:(might be solved)
Once I get into one of the news from that ListView, after I went back from the correspoding detail page, it will always being crashed...  
Maybe after solving this problem, this App could be used...  
But I still don't know why...and it's makes me rea;;y miserable of course...  
The Log which can be seen from the monitor just like this..  

`FATAL EXCEPTION: main <br />java.lang.IllegalStateException: The content of the adapter has changed but ListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ListView(2131492968, class android.widget.ListView) with Adapter(class com.saphir.test.dailynews.model.NewsListAdapter)]`

**since the refresh part of that ListView is in the onResume(), when I set finish with the DetailPage, it will do that method in the MainPage at once.So that might cause this crash. So I put this method in the onCreate(), and it looks work well.**

But I still not crealy understand why there will be a crash if I put that in the onResume()...or in another way to say is "Why it will cause a change of the ListViewAdapter(that's what the Log said) after I reload that ListView which exactly using the same adapter of course?" 

## Dependency
* android.support:appcompat-v7:23.1.1
* butterknife:V7.0.1
* greendao:V2.1.0
* autolayout:V1.4.3
