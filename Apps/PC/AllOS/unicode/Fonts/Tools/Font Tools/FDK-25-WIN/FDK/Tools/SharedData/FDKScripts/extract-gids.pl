#!/usr/bin/perl

# Written by Dr. Ken Lunde (lunde@adobe.com)
# Senior Computer Scientist, Adobe Systems Incorporated
# Version 06/26/2012
#
# This tool simply lists the GIDs in a font. The "-r" option will turn
# the list into ranges.

$file = $ARGV[0];
$second = $range = 0;

while ($ARGV[0]) {
    if ($ARGV[0] =~ /^-[huHU]/) {
        print STDERR "Usage: extract-gids.pl [-r] <font>\n";
        exit;
    } elsif ($ARGV[0] =~ /^-[rR]/) {
        $range = 1;
        shift;
    } else {
        $file = $ARGV[0];
        shift;
    }
}

open(FILE,"tx -1 $file |") or die "Cannot open $file input file!\n";

while(defined($line = <FILE>)) {
    chomp $line;
    next if $line !~ /glyph\[\d+\]/;
    ($gid) = $line =~ /glyph\[(\d+)\]/;

    if ($range) {
        if (not $second) {
            $orig = $previous = $gid;
            $second = 1;
            next;
        }
        if ($gid != $previous + 1) {
            if ($orig == $previous) {
                print STDOUT "$orig\n";
            } else {
                print STDOUT "$orig-$previous\n";
            }
            $orig = $previous = $gid;
        } else {
            $previous = $gid;
        }
    } else {
        print STDOUT "$gid\n";
    }
}

if ($range) {
    if ($orig == $previous) {
        print STDOUT "$orig\n";
    } else {
        print STDOUT "$orig-$previous\n";
    }
}
