package string;

import java.util.HashMap;

/**
let's find the web page with the most unique visitors for a log file

timestamp, customer, pageID
1, 1, Home
2, 1, Office365
3, 1, Word
4, 1, Excel
5, 1, Word
6, 2, Home
7, 2, Home
... (1 million more records follow)...

>> Home page, 2 unique visitors.

What's the fastest way to solve this problem?

##

## table = visitors

select count(*) from visitors;

####

select count(*) from visitors
group by pageID 

####

select max from (select count(*) from visitors group by pageID)

##

select max from (select count(DISTINCT customer) from visitors group by pageID)
/**
       
let's find the most frequently occuring 3 page path
where a 3 page path is a set of 3 pages visited in sequential order by a single customer

1 -> Home -> office365 -> Word
1 -> Office365 -> Word -> excel
1 -> Word -> Excel -> word
2 -> no 3 page paths, because they only visited one page (home,) and then they refreshed the page (home-> home doesn't count)
*/

 class LogFileReader {
 //returns null when the file is at the EOF marker or the next logfileline object from the file.
 public LogFileLine getNextLine(){
 //...
 }
 }
 
 class LogFileLine {
  public long customerId;
  public String pageId;
  public long timestamp;
}

//Approach 1
//read through the files
// build a linked list of paths for each customer
// read the ll 3 at a time, slide over it.. filter any refershes 
//and increment count for each distinct 3 path - in some path-to-count map
// compare map - get highest across all users.

//approach 2
// keep last 2 page ids for each customer in some store
// new id for a customer, check for refresh, if not increment count-map and refresh //last 2 page ids


public class PathUtil{

    //String here will be a composite string of path, plus separator
    private Map<String,Integer> countsMap = new HashMap<>();
    private Map<<Long,List<String>> custLastVisited = new HashMap<>();
    
    private boolean isRefresh(List<String> lv, String curr){
    //..
    } 
    
    private void updateLastVisited(long custId, String curr){
    
    //..
    }
    
    private String getMaxCount3PagePath(){
    // iterate through entryset of countsMap and return the max value
    
    }
    
    private String getKey(long customerId, List<String>  pageIds){
    
    
    }
    public long countHighest3PagePath(LogFileReader reader){
 
         while((LogFileLine lfl = reader.getNextLine())!=null){   
    
           List<String> lastVisited = custLastVisisted.get(lfl.customerId);
           
           if(!isRefresh(lastVisited),lfl.pageId){
               countsMap.get(getKey(cutomerId,pageIds)
               //update count
           }
           //update last visited,
        }
        
        getMaxCount3PagePath();
    }

}




       
