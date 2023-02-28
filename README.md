# SystemTask
Spring Boot Task

Steps to execute SystemTask Api:-
Setup MYSql and create a database with name ‘mf_db’
Run the springboot project , in localhost port 8080
For serache APIS , endpoint exposed 

1. Search api for Scheme:-Uri -
 https://localhost:8080:/mfdata/get/’schemeName’
	
	1.Stored data into local db received from this-’https://api.mfapi.in/mf’ api
	2. Created rest Api for display the schemes , on the basis of scheme Name
	     It, will search from stored data, and fetch Scheme Id.
3. Used Rest Templet to consume API ,’ https://api.mfapi.in/mf/100077’ will store 
	     In MFdataByCode.
4. Will return the MFdataByCode responce
	    		
	



2. .Search api for Scheme with Filter:-
 Uri- https://localhost:8080:/mfdata/get-by-filter
		Request format:- 
			{ "request": 
				{ "schemeId": 100077, 
				"filter": "1M" }
			 }
	1. Used Rest Templet to consume API ,’ https://api.mfapi.in/mf/100077’ will store 
	     In MFdataByCode.
2. Filter all the MFdataByCode and store in MFdataWithFilter.
Filtration technique:-  Filtering dates on the basis of request format :- 
"request": { "schemeId": 100077, "filter": "1M" } }
	Range= current date - encountered date;
if(1M && checking range in current date and target date )	the add in 
	result.	
	Similarly for:- (1M, 1W, 1Y, 5Y)		
