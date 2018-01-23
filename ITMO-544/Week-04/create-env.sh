#!/bin/bash

aws ec2 run-instances --image-id $1 --count $2 --key-name $3 --security-group-ids $4 --instance-type t2.micro --user-data file://install.sh
IDs=`aws ec2 describe-instances  --query 'Reservations[*].Instances[].InstanceId' --filters "Name=instance-state-name, Values=pending" --output text`
aws ec2 wait instance-running --instance-ids $IDs
aws elb create-load-balancer --load-balancer-name itmo-544-test --listeners "Protocol=HTTP,LoadBalancerPort=80,InstanceProtocol=HTTP,InstancePort=80" --availability-zones us-west-2a us-west-2b us-west-2c --security-groups $4
aws elb register-instances-with-load-balancer --load-balancer-name itmo-544-test --instances $IDs
aws elb create-load-balancer-listeners --load-balancer-name itmo-544-test --listeners "Protocol=TCP,LoadBalancerPort=4000,InstanceProtocol=TCP,InstancePort=4000"
aws elb create-lb-cookie-stickiness-policy --load-balancer-name itmo-544-test --policy-name duration-policy --cookie-expiration-period 60
aws elb set-load-balancer-policies-of-listener --load-balancer-name itmo-544-test --load-balancer-port 80 --policy-names duration-policy
