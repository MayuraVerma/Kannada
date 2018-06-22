#!/usr/bin/perl

# Written by Dr. Ken Lunde (lunde@adobe.com)
# Senior Computer Scientist, Adobe Systems Incorporated
# Version 06/26/2012
#
# This tool lists the CIDs in a CID-keyed font, which can be a CIDFont
# resource or a OpenType font that was built from a CIDFont resource.
# CIDs are prefixed with a slash. The "-r" option will turn the list
# into ranges, and the "-s" will additionally output the CID ranges
# onto a single line with comma seperators so that it can be repurposed,
# such as the argument for the "-g" option that is supported by many
# AFDKO tools.

$file = $ARGV[0];
$second = $range = 0;
$sep = "\n";

while ($ARGV[0]) {
    if ($ARGV[0] =~ /^-[huHU]/) {
        print STDERR "Usage: extract-cids.pl [-r] [-s] <CID-keyed font>\n";
        exit;
    } elsif ($ARGV[0] =~ /^-[rR]/) {
        $range = 1;
        shift;
    } elsif ($ARGV[0] =~ /^-[sS]/) {
        $sep = ",";
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
    die "ERROR: name-keyed font! Quitting...\n" if $line !~ /{(\d+),/;
    ($cid) = $line =~ /{(\d+),/;
    if ($range) {
        if (not $second) {
            $orig = $previous = $cid;
            $second = 1;
            next;
        }
        if ($cid != $previous + 1) {
            if ($orig == $previous) {
                print STDOUT "/$orig$sep";
            } else {
                print STDOUT "/$orig-/$previous$sep";
            }
            $orig = $previous = $cid;
        } else {
            $previous = $cid;
        }
    } else {
        print STDOUT "/$cid\n";
    }
}

if ($range) {
    if ($orig == $previous) {
        print STDOUT "/$orig\n";
    } else {
        print STDOUT "/$orig-/$previous\n";
    }
}
