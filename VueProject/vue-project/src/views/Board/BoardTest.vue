<template>
  <div>
    <v-data-table
      :headers="headers"
      :items="boards"
      :page.sync="pageInfo.pageNum"
      :items-per-page="pageInfo.itemLimit"
      hide-default-footer
      class="elevation-1"
      @page-count="pageInfo.total = $event"
    >
      <template v-slot:top>
        <v-toolbar flat>
          <v-toolbar-title>My CRUD</v-toolbar-title>
          <v-divider class="mx-4" inset vertical></v-divider>
          <v-spacer></v-spacer>
          <v-btn color="primary" dark @click.stop="dialogInfo.dialog = true">
            Open Dialog
          </v-btn>
          <v-dialog v-model="dialogInfo.dialog" max-width="290">
            <v-card>
              <v-card-title>
                <span class="text-h5">d</span>
              </v-card-title>

              <v-card-text>
                <v-container>
                  <v-row>
                    <v-col cols="12" sm="6" md="4">
                      <v-text-field
                        v-model="editedItem.name"
                        label="Dessert name"
                      ></v-text-field>
                    </v-col>
                    <v-col cols="12" sm="6" md="4">
                      <v-text-field
                        v-model="editedItem.calories"
                        label="Calories"
                      ></v-text-field>
                    </v-col>
                    <v-col cols="12" sm="6" md="4">
                      <v-text-field
                        v-model="editedItem.fat"
                        label="Fat (g)"
                      ></v-text-field>
                    </v-col>
                    <v-col cols="12" sm="6" md="4">
                      <v-text-field
                        v-model="editedItem.carbs"
                        label="Carbs (g)"
                      ></v-text-field>
                    </v-col>
                    <v-col cols="12" sm="6" md="4">
                      <v-text-field
                        v-model="editedItem.protein"
                        label="Protein (g)"
                      ></v-text-field>
                    </v-col>
                  </v-row>
                </v-container>
              </v-card-text>

              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="blue darken-1" text @click="close">
                  Cancel
                </v-btn>
                <v-btn color="blue darken-1" text @click="save"> Save </v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>
        </v-toolbar>
      </template>
    </v-data-table>
    <div class="text-center pt-2">
      <v-pagination
        v-model="pageInfo.startPage"
        :length="pageInfo.realEndPage"
      ></v-pagination>
    </div>
    {{ pageInfo.total }}
  </div>
</template>

<script>
export default {
  data() {
    return {
      dialogInfo: {
        dialog: false,
      },
      pageInfo: {
        pageNum: 1,
        itemLimit: 5,
        total: 0,
        pageLimit: 10,
        startPage: 1,
        endPage: 10,
        realEndPage: 10,
        startItem: 1,
        endItem: 10,
      },
      headers: [
        { text: "글 번호", value: "boardNumber" },
        { text: "글 제목", value: "boardTitle" },
        { text: "글 작성자", value: "memberId" },
        { text: "글 작성일", value: "boardDate" },
        { text: "조회수", value: "boardReadCount" },
      ],
      boards: [
        {
          boardNumber: "1",
          boardTitle: "Board Title",
          memberId: "user01",
          boardDate: "2021-10-22",
          boardReadCount: 0,
        },
        {
          boardNumber: "1",
          boardTitle: "Board Title",
          memberId: "user01",
          boardDate: "2021-10-22",
          boardReadCount: 0,
        },
        {
          boardNumber: "1",
          boardTitle: "Board Title",
          memberId: "user01",
          boardDate: "2021-10-22",
          boardReadCount: 0,
        },
        {
          boardNumber: "1",
          boardTitle: "Board Title",
          memberId: "user01",
          boardDate: "2021-10-22",
          boardReadCount: 0,
        },
        {
          boardNumber: "1",
          boardTitle: "Board Title",
          memberId: "user01",
          boardDate: "2021-10-22",
          boardReadCount: 0,
        },
        {
          boardNumber: "1",
          boardTitle: "Board Title",
          memberId: "user01",
          boardDate: "2021-10-22",
          boardReadCount: 0,
        },
        {
          boardNumber: "1",
          boardTitle: "Board Title",
          memberId: "user01",
          boardDate: "2021-10-22",
          boardReadCount: 0,
        },
        {
          boardNumber: "1",
          boardTitle: "Board Title",
          memberId: "user01",
          boardDate: "2021-10-22",
          boardReadCount: 0,
        },
        {
          boardNumber: "1",
          boardTitle: "Board Title",
          memberId: "user01",
          boardDate: "2021-10-22",
          boardReadCount: 0,
        },
        {
          boardNumber: "1",
          boardTitle: "Board Title",
          memberId: "user01",
          boardDate: "2021-10-22",
          boardReadCount: 0,
        },
        {
          boardNumber: "1",
          boardTitle: "Board Title",
          memberId: "user01",
          boardDate: "2021-10-22",
          boardReadCount: 0,
        },
        {
          boardNumber: "1",
          boardTitle: "Board Title",
          memberId: "user01",
          boardDate: "2021-10-22",
          boardReadCount: 0,
        },
      ],
    };
  },
};
</script>

<style></style>
