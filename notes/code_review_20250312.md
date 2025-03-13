## Code Review 03-12-2025

### ActionAddJournal Controller
- [ ] How to handle GenericDao insert() passing back insert ID
- [ ] Try catch block for exceptions? How to know which exceptions to catch?


### RouteViewJournalDetails Controller
- [ ] Show user / journal validation rerouting to unauthorized
- [ ] Gracefully handle journal that d/n exist (if coded into the URL)  

### ActionAddLake Controller
- [ ] Gracefully handle duplicate DB entry hibernate error
- [ ] Discuss same scenario for edit Lake

### CRUD
- [ ] Should all be in a try catch block?

### Log4J
- [ ] logger.info - add these throughout code for debugging
- [ ] logger.error - add these in my try catch blocks?
- [ ] Don't always understand which log to look

### API
- [ ] Okay to change my API? Still on the fence on Solunar vs Profile Photo

### AWS
- [ ] Charging .005 per hour for IPv4 on RDS

### General Workflow
- [ ] Discuss my approach on this


- User signs up and first name / last name is created
- User needs to add lakes and update their bass goals



### Notes:

Hello,

Dnyaneshwar here from AWS Accounts and Billing team, as my colleague Shramith is out of office, I am responding to you on his behalf. Trust my email finds you well.

I understand your concern with the IPv4 charges on your AWS account. I'll try my best to explain through this correspondence.

From your response, I understand that you want to know about the charges for Virtual Private Cloud

As per your AWS Bills - under Virtual Private Cloud you will see 2 charges
1st - $0.00 per In-use public IPv4 address per hour for EC2 Free Tier
2nd - $0.005 per In-use public IPv4 address per hour

1. "AssociateAddressVPC" operation for IPv4 address is related to elastic IP connected with EC2 which is Free
2.  The  "DescribeNetworkInterfaces" operation for IPv4 address is related to RDSNetworkInterface as there is attached ENI with RDS instance which is not Free.

You can find the ENI using the AWS Management Console. On the Amazon Elastic Compute Cloud (Amazon EC2) console, choose Network interfaces in the navigation pane >> You will see Two ENIs 1 with EC2 and the other 1 with RDS.

IMPORTANT NOTE : 750 hours of public IPv4 address usage per month is only Free when you are using the Public IP with EC2 service and your AWS Account is under Free tier. If you are using Public IP with any other service than EC2 or Free Tier is expired on the account, then a charge of $0.005 per IP per hour will be present on the account.

Please refer - Why am I seeing charges for 'Public IPv4 addresses' when I am under the AWS free tier?
https://repost.aws/articles/ARknH_OR0cTvqoTfJrVGaB8A/why-am-i-seeing-charges-for-public-ipv4-addresses-when-i-am-under-the-aws-free-tier

Thank you for your understanding in this regard.

If you have any additional questions or if you need any further assistance, feel free to contact us at any time. We'll always be here to help you.

Have a wonderful day.

We value your feedback. Please share your experience by rating this and other correspondences in the AWS Support Center. You can rate a correspondence by selecting the stars in the top right corner of the correspondence.