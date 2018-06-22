#!/usr/bin/perl

$file = $ARGV[0];

open(FILE,"tx -1 $file |") or die "Cannot open $file input file!\n";

while(defined($line = <FILE>)) {
    chomp $line;
    next if $line !~ /glyph\[\d+\]/;
    ($glyph) = $line =~ /{(.+?),/;
    next if $glyph eq ".notdef";
    print STDOUT "$glyph\n";
}
