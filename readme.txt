Converting tab separated file with the following nested structure to JSON file
Like this,

structure:
    A:  <ClSz>  <TotFq>  <Root>  <ClId>
    B:          <QtFq>   <Urls>  <QtStr>  <QtId>
    C:                   <Tm>    <Fq>     <UrlTy>  <Url>

source:
http://memetracker.org/data.html

DripJSON.java make JSON format (for Mongo DB) :
{"ClSz":35, "TotFq":1989, "Root":"i loved it", "ClusterId":808036, "QtFq":209, "Urls":205, "QtStr":"i was never the same again i wasn't my own man anymore i was my country's", "QuteId":807448, "Tm":"2008-09-05 03:51:30", "Fq":1, "UrlTy":"B", "Url":"http://timesreporter.com/"}
{"ClSz":35, "TotFq":1989, "Root":"i loved it", "ClusterId":808036, "QtFq":209, "Urls":205, "QtStr":"i was never the same again i wasn't my own man anymore i was my country's", "QuteId":807448, "Tm":"2008-08-01 01:04:31", "Fq":1, "UrlTy":"M", "Url":"http://mininova.org/"}

DropJSON.java make JSON format :
[{"ClSz":35, "TotFq":1989, "Root":"i loved it", "ClusterId":808036, "QtFq":209, "Urls":205, "QtStr":"i was never the same again i wasn't my own man anymore i was my country's", "QuteId":807448, "Tm":"2008-09-05 03:51:30", "Fq":1, "UrlTy":"B", "Url":"http://timesreporter.com/"}
,{"ClSz":35, "TotFq":1989, "Root":"i loved it", "ClusterId":808036, "QtFq":209, "Urls":205, "QtStr":"i was never the same again i wasn't my own man anymore i was my country's", "QuteId":807448, "Tm":"2008-08-01 01:04:31", "Fq":1, "UrlTy":"M", "Url":"http://mininova.org/"}]