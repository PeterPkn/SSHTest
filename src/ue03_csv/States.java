package ue03_csv;

import u02_enum2.IncrementWord;

public enum States {
    outCell{
        @Override
        public States handleChar(AddWord context, char ch) {
            return null;
        }
    },
    inCell{
        @Override
        public States handleChar(AddWord context, char ch) {
            return null;
        }
    },
    semicolon{
        @Override
        public States handleChar(AddWord context, char ch) {
            return null;
        }
    },
    inQuotes{
        @Override
        public States handleChar(AddWord context, char ch) {
            return null;
        }
    },
    unusedQuotes{
        @Override
        public States handleChar(AddWord context, char ch) {
            return null;
        }
    };
    public abstract States handleChar(AddWord context, char ch);
}
