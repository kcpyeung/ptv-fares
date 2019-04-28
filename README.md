# ptv-fares

Compute the best [Myki Pass](https://www.ptv.vic.gov.au/tickets/fares/metropolitan-fares/) to buy.
From the table, it's shown that the cheapest daily fare is the 33-day pass, assuming:

* 5 weekdays a week of travel,
* no weekend travel.

At 33 days, wastefulness is the lowest. Wastefulness is defined as:

weekend days thrown away / myki pass days purchased

Starting from 33 days, every additional 7 days purchased will cause wastefulness to increase because we're adding 2 days of waste 
in every 7 days of additional pass. It's easy to show:

(a + 2) / (b + 7) > a / b, [ a > 0, b > 0, b > a, a / b < 2 / 7 ]

The constant in the last constraint, a/b < 2/7, is exactly 8/28, given by the 28-day pass. The 33-day pass games the system 
by adding 5 useful weekdays without any additional wasted weekends.  

## Usage

```lein run```

Requires leiningen.

## License

Copyright © 2019 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
