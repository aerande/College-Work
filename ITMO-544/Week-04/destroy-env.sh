#!/bin/bash

IDs=`aws ec2 describe-instances --query 'Reservations[*].Instances[].InstanceId' --filter "Name=instance-state-name, Values=running" --output text`
aws elb deregister-instances-from-load-balancer --load-balancer-name itmo-544-test --instances $IDs
aws elb delete-load-balancer-listeners --load-balancer-name itmo-544-test --load-balancer-ports 80 4000
aws elb delete-load-balancer --load-balancer-name itmo-544-test
aws ec2 terminate-instances --instance-ids $cloud