public class Index {

        int itemNo;
        int position;

        public Index(int itemNo, int position) {
            this.itemNo = itemNo;
            this.position = position;
        }

        public int GetItemNo() {

            return this.itemNo;
        }

        public int GetPosition() {

            return this.position;
        }

        public void DisplayNrIndex() {

            System.out.printf("%s, %s", this.itemNo, this.position);
        }
        public void SetPosition(int position) {
            this.position = position;
        }

}
