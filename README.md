# DailyNews
An exercise for MVP pattern~ also using the RSS parse with SAX~  NOT FINISHED YET=、=

<h2 style="font-color:#ff7d7d">Problem</h2>
  <li>Problem 1:(solved)</li>
    <p>WHY DOES THIS CODE NOT WORK ?! </p><br />
    <code>InputStream mInputStream = urlc.getInputStream();</code>
    <p>&nbsp;&nbsp;&nbsp;&nbsp;With no exception...only can be seen through the logcat...</p>
    <strong>Because we COULD NOT using a delay operator in the main thread, which exactly the NET CONNECTION is.</strong>
    <br />
  <li>Problem 2:(solved)</li>
    <p>About Bundle transform between the two Activity...</p>
    <p>Actually I know how to receive the parameter in the normal way...but not in this mvp pattern...= =So sad.</p>
    <p><strong>WHERE</strong> Should I get that bundle ?</p>
    <p>&nbsp;&nbsp;<strong>SOLVE:</strong>&nbsp;We could put the methods about set or get Bundle in the View part.And then using them through the function of the presenter by invoke...At least I think it should be like this...
    <br />
  <li>Problem 3:</li>
    <p>Once I get into one of the news from that ListView, after I went back from the correspoding detail page, it will always being crashed...</p>
    <p>Maybe after solving this problem, this App could be used...</p>
    <p>But I still don't know why...and it's makes me rea;;y miserable of course...</p>
    <p>The Log which can be seen from the monitor just like this..</p>
    <code>FATAL EXCEPTION: main <br />java.lang.IllegalStateException: The content of the adapter has changed but ListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ListView(2131492968, class android.widget.ListView) with Adapter(class com.saphir.test.dailynews.model.NewsListAdapter)]</code>
    <br />
<h2 style="font-color:#ff7d7d">Dependency</h2>
  <div>
  <li>android.support:appcompat-v7:23.1.1</li>
  <li>butterknife:V7.0.1</li>
  <li>greendao:V2.1.0</li>
  <li>autolayout:V1.4.3</li>
  </div>
