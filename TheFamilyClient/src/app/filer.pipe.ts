import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filer'
})
// export class FilerPipe implements PipeTransform {
//   transform(items: any[], searchText: string): any[] {
//     if(!items) return [];
//     if(!searchText) return items;
// searchText = searchText.toLowerCase();
// return items.filter( it => {
//       return it.toLowerCase().includes(searchText);
//     });
//    }
// }
export class FilerPipe implements PipeTransform {

  transform(arr: string[], key:string): string[] {
    let newArray = [];
    for(let i in arr){
      let str = arr[i].toLowerCase();
      if(str.includes(key.toLowerCase())){
        newArray.push(arr[i]);
      }
    }
    return newArray;
  }

}
