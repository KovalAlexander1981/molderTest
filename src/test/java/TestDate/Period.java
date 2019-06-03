package TestDate;

public enum Period {
        oneDay("1D"), fiveDay("5D"), threeMonth("3M"), sixMonth("6M"),
    yearCurrent("YTD"), oneYear("1Y"), fiveYear("5Y"), max("MAX");

        String name;

    Period(String name) {
            this.name = name;
        }


        @Override
        public String toString() {
            return name;
        }
    }



