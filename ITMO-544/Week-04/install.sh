#!/bin/bash

sudo apt-get update
sudo apt-get install -y apache2
sudo service apache2 start
sudo apt-get install ruby -y
sudo apt-get install ruby-dev -y
sudo apt-get install ruby-bundler -y
sudo apt-get install build-essential patch -y
sudo apt install jekyll -y
git clone https://github.com/jhajek/forge.git
cd forge
bundle install
bundle exec jekyll serve --host 0.0.0.0
