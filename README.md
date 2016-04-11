# DailyNews
An exercise for MVP pattern~ also using the RSS parse with SAX~  NOT FINISHED YET=、=

<h2 style="font-color:#ff7d7d">Problem</h2>
  <li>Problem 1:(solved)</li>
    <p>WHY DOES THIS CODE NOT WORK ?! </p><br />
    <code>InputStream mInputStream = urlc.getInputStream();</code>
    <p>With no exception...only can be seen through the logcat...</p>
    <strong>Because we COULD NOT using a delay operator in the main thread, which exactly the NET CONNECTION is.</strong>
  <li>Problem 2:</li>
    <p>About Bundle transform between the two Activity...</p>
    <p>Actually I know how to receive the parameter in the normal way...but not in this mvp pattern...= =So sad.</p>
    <p><strong>WHERE</strong> Should I get that bundle ?</p>
    <p>In the DetailPresenter? or open a new interactor?</p>
<h2 style="font-color:#ff7d7d">Dependency</h2>
  <div>
  <li>android.support:appcompat-v7:23.1.1</li>
  <li>butterknife:V7.0.1</li>
  <li>greendao:V2.1.0</li>
  <li>autolayout:V1.4.3</li>
  </div>
