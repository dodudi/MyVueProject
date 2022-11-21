<template>
  <div>
    <v-app>
      <v-main>
        <v-container style="width: 800px">
          <v-card>
            <v-responsive :aspect-ratio="16 / 9">
              <v-card-text>
                Board Number : {{ $route.params.board_NUMBER }}
                <v-divider></v-divider>
                Board Title : {{ $route.params.board_TITLE }}
                <v-divider></v-divider>
                Member ID : {{ $route.params.member_ID }}
                <v-divider></v-divider>
                Board Date : {{ $route.params.board_DATE }}
                <v-divider></v-divider>
                Board ReadCount : {{ $route.params.board_READCOUNT }}
                <v-divider class="mb-4"></v-divider>
                {{ $route.params.board_CONTENT }}
                rakwelfkawe;fkaewlfkawel;fkl;
              </v-card-text>
            </v-responsive>
          </v-card>
        </v-container>
      </v-main>
    </v-app>
  </div>
</template>

<script>
export default {};
</script>

<style></style>
